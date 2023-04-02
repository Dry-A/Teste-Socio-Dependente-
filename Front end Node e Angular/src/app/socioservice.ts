import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Socio } from './socio';
import { map } from 'rxjs/operators';
import { Dependente } from './dependente';
import { switchMap } from 'rxjs/operators';
import { forkJoin } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class SocioService {
private baseURL = "http://localhost:8080/socios";

constructor(private httpClient : HttpClient ) {
    
}
getSocioList(): Observable <Socio []>{
    
 return this.httpClient.get<Socio[]>(`${this.baseURL}`);
}

getSociosComDependentes(): Observable<Map<Socio, Dependente[]>> {
  const socios$: Observable<Socio[]> = this.httpClient.get<Socio[]>(`${this.baseURL}`);

  const dependentesPorSocio$: Observable<Map<Socio, Dependente[]>> = socios$.pipe(
    map(socios => {
      const dependentesObservables = socios.map(socio => this.httpClient.get<Dependente[]>(`${this.baseURL}/${socio.id}/dependentes`));
      return { socios, dependentesObservables };
    }),
    switchMap(({ socios, dependentesObservables }) => {
      return forkJoin(dependentesObservables).pipe(
        map(dependentesArrays => {
          const dependentesPorSocio = new Map<Socio, Dependente[]>();
          socios.forEach((socio, index) => dependentesPorSocio.set(socio, dependentesArrays[index]));
          return dependentesPorSocio;
        })
      );
    })
  );

  return dependentesPorSocio$;
}

createSocio(socio: Socio): Observable <Object>{
  return this.httpClient.post(`${this.baseURL}`, socio);
 }

getSocioById(id:number): Observable <Socio>{
  return this.httpClient.get<Socio>(`${this.baseURL}/${id}`);
}

updateSocioByid(id:number,socio: Socio): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${id}`, socio);
}

deleteSocioByid(id:number):Observable <Object>{
return this.httpClient.delete(`${this.baseURL}/${id}`);
}
}

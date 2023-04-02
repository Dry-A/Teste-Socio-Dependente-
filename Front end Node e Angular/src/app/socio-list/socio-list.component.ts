import { SocioService } from '../socioservice';
import { Socio } from '../socio';
import { Component, OnInit, PipeTransform } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { Dependente } from '../dependente';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-socio-list',
  templateUrl: './socio-list.component.html',
  styleUrls: ['./socio-list.component.css'],
})

export class SocioListComponent implements OnInit {
  socios!: Socio[];
  sociosList$: Observable<Socio[]>;
  filter = new FormControl('', { nonNullable: true });

  constructor(private socioService:SocioService, private router:Router ) { 
  }

  private getSocios(){
    this.socioService.getSocioList().subscribe(data => {
      this.socios = data;
    })
  }
  socioDetails(id:number){
    this.router.navigate(['socios-details',id])
  }
  socioUpdate(id:number){
    this.router.navigate(['update-socios',id])
  }
  socioDelete(id:number){
    this.socios.splice(this.socios.findIndex(cache_map => cache_map.id === id),1);
    this.socioService.deleteSocioByid(id).subscribe();
    }

    ngOnInit(): void {
    this.getSocios();
    }

  }



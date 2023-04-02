import { Dependente } from './dependente';

export class Socio {
  static filter(arg0: (country: any) => any): Socio[] {
    throw new Error('Method not implemented.');
  }
    
    id : number; 
    nome : string;
    renda : number;
    ativo: Boolean;
    dependentes: Dependente[];

     constructor() {
    this.dependentes = [];
  }
}
import { CreateDependente } from './create-dependente/create-dependente.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSocioComponent } from './create-socio/create-socio.component';
import { SocioListComponent } from './socio-list/socio-list.component';
import { UpdateSocioComponent } from './update-socio/update-socio.component';
import { HttpClientModule } from '@angular/common/http';
import { DependenteListComponent } from './dependente-list/dependente-list.component';
import { DepedenteDetailsComponent } from './dependente-details/dependente-details.component';
import { UpdateDepedenteComponent } from './update-dependente/update-dependente.component';
import { SocioService } from './socioservice';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';


@NgModule({
  declarations: [
    AppComponent,
    CreateSocioComponent,
    SocioListComponent,
    UpdateSocioComponent,
    CreateDependente,
    DependenteListComponent,
    DepedenteDetailsComponent,
    UpdateDepedenteComponent,
    CreateDependente
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [
    AppComponent,
    CreateSocioComponent,
    SocioListComponent,
    SocioService,
    UpdateSocioComponent,
    CreateDependente,
    DependenteListComponent,
    DepedenteDetailsComponent,
    UpdateDepedenteComponent]
})
export class AppModule { }

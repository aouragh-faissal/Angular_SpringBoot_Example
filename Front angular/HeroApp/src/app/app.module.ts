import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AjoutComponent } from './ajout/ajout.component';
import { ListComponent } from './list/list.component';
import { HeaderComponent } from './header/header.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { provideHttpClient, withFetch } from "@angular/common/http";
import { UpdateComponent } from './update/update.component';



@NgModule({
  declarations: [
    AppComponent,
    AjoutComponent,
    ListComponent,
    HeaderComponent,
    NotFoundComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule
  ],
  providers: [provideHttpClient(withFetch())],
  bootstrap: [AppComponent]
})
export class AppModule { }

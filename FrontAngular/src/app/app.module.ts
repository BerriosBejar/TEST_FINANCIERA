import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from 'src/app/components/navbar/navbar.component';
import { HomePage } from 'src/app/pages/home/home.page';
import { VentasPage } from 'src/app/pages/ventas/ventas.page';
import { PageNotFoundComponent } from 'src/app/components/page-not-found/page-not-found.component';
import { FormsModule } from '@angular/forms';
import { PopupComponent } from 'src/app/components/popup/popup.component';
import { InputLabelComponent } from 'src/app/components/imput-label/input-label.component';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomePage,
    VentasPage,
    InputLabelComponent,
    PopupComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    RouterModule.forRoot([
      {path: '', component:HomePage},
      {path: 'ventas', component:VentasPage},
      {path: '**', component:PageNotFoundComponent},
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

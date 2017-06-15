import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';

import { CategoryTitleComponent } from './categorytitle.component';
import { CVComponent } from './cv.component';
import { FooterComponent } from './footer.component';
import { LanguageItemComponent } from './languageitem.component';
import { NavbarComponent } from './navbar.component';
import { PortfolioComponent } from './portfolio.component';
import { PortfolioItemComponent } from './portfolioitem.component';
import { ScreenTitleComponent } from './screentitle.component';
import { TechItemComponent } from './techitem.component';
import { WorkItemComponent } from './workitem.component';

import { DataService } from './data.service';

const routes: Routes = [
  {path:'portfolio', component:PortfolioComponent },
  {path:'cv', component:CVComponent },
  {path:'w', component:ScreenTitleComponent },
  {path:'**',redirectTo:'/portfolio',pathMatch:'full'},
  {path:'',redirectTo:'/portfolio',pathMatch:'full'}
];

@NgModule({
  declarations: [
    AppComponent, 
    NavbarComponent,
    PortfolioComponent,
    ScreenTitleComponent,
    PortfolioItemComponent,
    CVComponent,
    CategoryTitleComponent,
    WorkItemComponent,
    TechItemComponent,
    LanguageItemComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    DataService
  ],
  bootstrap: [
   AppComponent
  ]
})
export class AppModule { }

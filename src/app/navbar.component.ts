import { Component } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'
import * as $ from 'jquery';

@Component({
  selector: 'nav-bar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent extends DataSubscribedComponent {
  title:string;
  languages:any[];
  portfolioTitle:string;
  cvTitle:string;
  contactTitle:string;
  languageSelectorOpen:boolean = false;

  goToContact():void{
    this.scrollTo('footer');
  }

  goToPortfolio():void{
    $('html, body').animate({
      scrollTop: 0
    }, 1000);    
  }

  goToCV():void{
    this.scrollTo('cv');
  }

  private scrollTo(domID:string):void{
    $('html, body').animate({
      scrollTop: $(`#${domID}`).offset().top - 100
    }, 1000);    
  }

  setLanguage(language:string):void{
    this.setDataLanguage(language);
    this.languageSelectorOpen = false;
  }

  onLanguageChanged(language:string):void{
    this.updateData(this.getCVData());
  }

  onCVDataChanged(cvData:any):void{
    this.updateData(cvData);
  }

  updateData(cvdata:any):void{
    let lang = this.getLanguage();
    this.title = cvdata.navbar.title[lang];
    this.portfolioTitle = cvdata.navbar.menu.portfolio.title[lang];
    this.cvTitle = cvdata.navbar.menu.cv.title[lang];
    this.contactTitle = cvdata.navbar.menu.contact.title[lang];

    this.languages = [];
    for (let language of cvdata.languages){
      this.languages.push({code:language.code,name:language.name[lang]});
    }


  }

  toggleLanguageSelector():void{
    this.languageSelectorOpen = !this.languageSelectorOpen;
  }
}
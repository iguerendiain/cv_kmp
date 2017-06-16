import { Component } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

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
      window.scrollTo(0,document.body.scrollHeight);
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
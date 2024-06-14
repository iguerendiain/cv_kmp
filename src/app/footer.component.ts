import { Component } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

@Component({
  selector: 'footer-section',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})

export class FooterComponent extends DataSubscribedComponent{
  title:string = null;
  avatar:string = null;
  linkedin:string = null;
  email:string = null;
  creditsTitle:string = null;
  creditsName:string = null;
  creditsLink:string = null;

  onLanguageChanged(language:string):void{
    this.updateData(this.getCVData());
  }

  onCVDataChanged(cvData:any):void{
    this.updateData(cvData);
  }

  updateData(cvdata:any):void{
    this.title = cvdata.contact.title[this.getLanguage()];
    this.avatar = cvdata.contact.avatar;
    this.linkedin = cvdata.contact.linkedin;
    this.email = cvdata.contact.email;
    this.creditsTitle = cvdata.contact.UIcredits.title[this.getLanguage()];
    this.creditsName = cvdata.contact.UIcredits.name;
    this.creditsLink = cvdata.contact.UIcredits.link;
  }

}
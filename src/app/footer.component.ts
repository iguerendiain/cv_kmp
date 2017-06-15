import { Component } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

@Component({
  selector: 'footer-section',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})

export class FooterComponent extends DataSubscribedComponent{
  avatar:string = null;
  linkedin:string = null;
  google:string = null;
  creditsName:string = null;
  creditsLink:string = null;

  onLanguageChanged(language:string):void{
    this.updateData(this.getCVData());
  }

  onCVDataChanged(cvData:any):void{
    this.updateData(cvData);
  }

  updateData(cvdata:any):void{
    this.avatar = cvdata.contact.avatar;
    this.linkedin = cvdata.contact.linkedin;
    this.google = cvdata.contact.google;
    this.creditsName = cvdata.contact.UIcredits.name;
    this.creditsLink = cvdata.contact.UIcredits.link;
  }

}
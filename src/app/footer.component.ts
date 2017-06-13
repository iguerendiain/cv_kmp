import { Component,OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'footer-section',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})

export class FooterComponent {
  avatar:string;
  linkedin:string;
  google:string;
  creditsName:string;
  creditsLink:string;

  constructor(private data:DataService){}

  ngOnInit():void{
    let cvdata = this.data.getData();

    this.avatar = cvdata.contact.avatar;
    this.linkedin = cvdata.contact.linkedin;
    this.google = cvdata.contact.google;
    this.creditsName = cvdata.contact.UIcredits.name;
    this.creditsLink = cvdata.contact.UIcredits.link;
  }

}
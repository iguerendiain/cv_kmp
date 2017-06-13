import { Component,OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'cv-screen',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})

export class CVComponent {
  title:string;
  workTitle:string;
  techTitle:string;
  langTitle:string;
  languages:[any];
  works:[any];
  techs:[any];

  constructor(private data:DataService){}
  
  ngOnInit():void{
    let cvdata = this.data.getData();
    this.title = cvdata.cv.title[this.data.getLanguage()];
    this.workTitle = cvdata.cv.work.title[this.data.getLanguage()];
    this.techTitle = cvdata.cv.tech.title[this.data.getLanguage()];
    this.langTitle = cvdata.cv.languages.title[this.data.getLanguage()];
    this.languages = cvdata.cv.languages.content;
    this.works = cvdata.cv.work.content;
    this.techs = cvdata.cv.tech.content;
  }
  
}
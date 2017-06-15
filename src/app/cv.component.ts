import { Component,OnInit } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

@Component({
  selector: 'cv-screen',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})

export class CVComponent extends DataSubscribedComponent{
  dataAvailable:boolean = false;
  title:string = null;
  workTitle:string = null;
  workContent:any[] = null;
  techTitle:string = null;
  techContent:any[] = null;
  langTitle:string = null;
  langContent:any[] = null;

  ngOnInit():void{
    this.updateData(this.getCVData());
  }

  onLanguageChanged(language:string):void{
    this.updateData(this.getCVData());
  }

  onCVDataChanged(cvData:any):void{
    this.updateData(cvData);
  }

  updateData(cvData:any):void{
    if (cvData!=null){
      this.dataAvailable = true;
      this.title = cvData.cv.title[this.getLanguage()];
      this.workTitle = cvData.cv.work.title[this.getLanguage()];
      this.workContent = cvData.cv.work.content;
      this.techTitle = cvData.cv.tech.title[this.getLanguage()];
      this.techContent = cvData.cv.tech.content;
      this.langTitle = cvData.cv.languages.title[this.getLanguage()];
      this.langContent = cvData.cv.languages.content;
    }else{
      this.dataAvailable = false;
      this.title = null;
      this.workTitle = null;
      this.workContent = null;
      this.techTitle = null;
      this.techContent = null;
      this.langTitle = null;
      this.langContent = null;      
    }
  }
}
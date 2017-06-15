import { Component,OnInit,OnChanges } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

@Component({
  selector: 'portfolio-screen',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})

export class PortfolioComponent extends DataSubscribedComponent{
  dataAvailable:boolean = false;
  title:string = null;
  projects:any[] = null;

  ngOnInit():void{
    this.updateData(this.getCVData());
  }

  onLanguageChanged(language:string):void{
    this.updateData(this.getCVData());
  }

  onCVDataChanged(cvData:any):void{
    this.updateData(cvData);
  }

  updateData(cvdata:any):void{
    if (cvdata!=null){
      this.dataAvailable = true;
      this.title = cvdata.portfolio.title[this.getLanguage()];
      this.projects = cvdata.portfolio.projects;
    }else{
        this.dataAvailable = false;
        this.title = null;
        this.projects = null;
    }
  }
  
}
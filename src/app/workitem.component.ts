import { Component,Input,OnInit } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

@Component({
  selector: 'work-item',
  templateUrl: './workitem.component.html',
  styleUrls: ['./workitem.component.css']
})

export class WorkItemComponent extends DataSubscribedComponent{
  @Input() item:any;
  title:string;
  from:string;
  to:string;
  description:string;
  url:string;

  updateData():void{
    let lang = this.getLanguage();
    this.title = this.item.title[lang];

    let dateFrom = new Date(this.item.from*1000);
    let dateTo;
    if (this.item.to!=null){
      dateTo = new Date(this.item.to*1000);
    }else{
      dateTo = null;
    }

    this.from = this.formatDate(dateFrom);
    if (dateTo!=null){
      this.to = this.formatDate(dateTo);
    }
    
    this.description = this.item.description[lang];
    this.url = this.item.url;
  }

  formatDate(date:Date):string{
    date.setTime(date.getTime() + 3600*3*1000);

    var months = this.getCVData().months[this.getLanguage()];
    
    let month = months[date.getMonth()];
    let year = date.getFullYear();

    return month+" "+year;
  }

  ngOnInit():void{
    this.updateData();
  }

  onLanguageChanged(language:string):void{
    this.updateData();
  }

  onCVDataChanged(cvData:any):void{
    this.updateData();
  }
  
}
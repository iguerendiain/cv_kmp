import { Component,Input,OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'work-item',
  templateUrl: './workitem.component.html',
  styleUrls: ['./workitem.component.css']
})

export class WorkItemComponent {
  @Input() item:any;
  title:string;
  from:string;
  to:string;
  description:string;
  url:string;

  constructor(private data:DataService){}

  ngOnInit():void{
    let lang = this.data.getLanguage();
    this.title = this.item.title[lang];

    let dateFrom = new Date(this.item.from*1000);
    let dateTo;
    if (this.item.to!=null){
      dateTo = new Date(this.item.to*1000);
    }else{
      dateTo = null;
    }

    this.from = dateFrom.toString();
    if (dateTo!=null){
      this.to = dateTo.toString();
    }
    
    this.description = this.item.description[lang];
    this.url = this.item.url;
  }
}
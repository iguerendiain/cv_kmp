import { Component,Input,OnInit } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

@Component({
  selector: 'tech-item',
  templateUrl: './techitem.component.html',
  styleUrls: ['./techitem.component.css']
})

export class TechItemComponent extends DataSubscribedComponent{
  @Input() item:any;

  title:string;
  content:string[];

  ngOnInit():void{
    this.updateData();
  }

  onLanguageChanged(language:string):void{
    this.updateData();
  }

  onCVDataChanged(cvData:any):void{
    this.updateData();
  }

  updateData():void{
    let lang = this.getLanguage();
    this.title = this.item.title[lang];
    this.content = this.item.content;
  }

}
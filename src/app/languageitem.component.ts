import { Component,Input } from '@angular/core';
import { DataSubscribedComponent } from './datasubscribedcomponent'

@Component({
  selector: 'language-item',
  templateUrl: './languageitem.component.html',
  styleUrls: ['./languageitem.component.css']
})

export class LanguageItemComponent extends DataSubscribedComponent{
  @Input() item:any;

  title:string;
  description:string;

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
    this.title = this.item.title[this.getLanguage()];
    this.description = this.item.description[this.getLanguage()];
  }


}
import { Component,Input,OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'language-item',
  templateUrl: './languageitem.component.html',
  styleUrls: ['./languageitem.component.css']
})

export class LanguageItemComponent {
  @Input() item:any;

  title:string;
  description:string;

  constructor(private data:DataService){}

  ngOnInit():void{
    this.title = this.item.title[this.data.getLanguage()];
    this.description = this.item.description[this.data.getLanguage()];
  }
}
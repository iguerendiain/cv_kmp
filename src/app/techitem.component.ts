import { Component,Input,OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'tech-item',
  templateUrl: './techitem.component.html',
  styleUrls: ['./techitem.component.css']
})

export class TechItemComponent {
  @Input() item:any;

  title:string;
  content:string[];

  constructor(private data:DataService){}

  ngOnInit():void{
    let lang = this.data.getLanguage();
    this.title = this.item.title[lang];
    this.content = this.item.content;
  }

}
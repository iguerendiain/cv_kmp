import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'nav-bar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent {
  title:string;
  languages:[string];

  constructor(private data:DataService){
  }

  ngOnInit():void{
    let cvdata = this.data.getData();
    this.title = cvdata.navbar.title[this.data.getLanguage()];
    this.languages = cvdata.languages;
  }

}
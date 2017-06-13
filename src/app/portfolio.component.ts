import { Component,OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'portfolio-screen',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})

export class PortfolioComponent {
  title:string;
  projects:[any];

  constructor(private data:DataService){}

  ngOnInit():void{
    let cvdata = this.data.getData();
    this.title = cvdata.portfolio.title[this.data.getLanguage()];
    this.projects = cvdata.portfolio.projects;
  }
  
}
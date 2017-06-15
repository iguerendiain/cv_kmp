import { Component,OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'app-root',
  providers:[DataService],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  constructor(private data:DataService){}

  ngOnInit():void{
    this.data.downloadData().subscribe(cvData => this.init(cvData));
  }

  init(cvData):void{
    this.data.setData(cvData);
  }

}

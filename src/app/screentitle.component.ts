import { Component, Input } from '@angular/core';

@Component({
  selector: 'screen-title',
  templateUrl: './screentitle.component.html',
  styleUrls: ['./screentitle.component.css']
})

export class ScreenTitleComponent {
    @Input() title:string;
}
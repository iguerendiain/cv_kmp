import { Component, Input } from '@angular/core';

@Component({
  selector: 'category-title',
  templateUrl: './categorytitle.component.html',
  styleUrls: ['./categorytitle.component.css']
})

export class CategoryTitleComponent {
  @Input() title:string;
}
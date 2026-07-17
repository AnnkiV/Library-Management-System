import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {
 
  title= "Library";

  totalBooks:number=250;

  totalLibrarians:number=10;

  books:string[]=[
  "Java",
  "Spring",
  "Angular"
  ];

  name:string="Ankita";

  age:number=22;

  isAdmin:boolean=true;

  buttonDisabled = false;

  imageUrl = "assets/images/library.png";

  
}

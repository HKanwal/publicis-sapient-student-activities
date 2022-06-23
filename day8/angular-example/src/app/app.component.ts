import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  users = [
    { name: "Alex", age: 35, gender: "Male" },
    { name: "Suma", age: 40, gender: "Female" },
    { name: "Hark", age: 22, gender: "Male" },
    { name: "Paul", age: 22, gender: "Male" },
    { name: "Jeremie", age: 21, gender: "Male" }
  ];
}

import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
  }

  loggedInUser(){
    if(this.authenticationService.loggedInUser() == true ){
      return true;
    }
    else {
      return false;
    }
  }

  get user(): any {
    return JSON.parse(localStorage.getItem('currentUser'));
}

  logOutUser() {
    this.authenticationService.logout();
    this.router.navigate(["home"]);
  }

}

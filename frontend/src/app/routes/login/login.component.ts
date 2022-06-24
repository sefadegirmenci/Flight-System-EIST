import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {UserService} from "../../services/users/user-service.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  error: string | null = null;

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
  }

  submit() {
    let username = this.form.value["username"];
    let password = this.form.value["password"];

    if (this.userService.login(username, password)) {
      console.log("Login worked");
      this.error = null;
      this.router.navigate(["/"]);
    } else {
      this.error = "Invalid username or password"
    }
  }
}

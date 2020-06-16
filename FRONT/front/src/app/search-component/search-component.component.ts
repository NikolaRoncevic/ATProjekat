import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { environment } from './../../environments/environment';

@Component({
  selector: 'app-search-component',
  templateUrl: './search-component.component.html',
  styleUrls: ['./search-component.component.css']
})
export class SearchComponentComponent implements OnInit {
  timA : any;
  timB : any;
  host : any;
  socket : any;
  constructor(public service : ServiceService) { }

  ngOnInit() {
    this.host = "ws://" + environment.baseAddress + ":8080/WAR2020/ws";

    try {
      this.socket = new WebSocket(this.host);
      var self = this;

      this.socket.onopen = function () {

      }

      this.socket.onmessage = function (msg) {
        alert(msg.data)
      }

      this.socket.onclose = function () {
        this.socket = null;
      }

    } catch (exception) {
      console.log('Error' + exception);
    }
  }
  search() {
    this.service.search(this.timA,this.timB).subscribe(
      (data) => {
      }
    )
  }

}

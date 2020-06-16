import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { environment } from './../../environments/environment';

@Component({
  selector: 'app-pravljenje-agenata',
  templateUrl: './pravljenje-agenata.component.html',
  styleUrls: ['./pravljenje-agenata.component.css']
})
export class PravljenjeAgenataComponent implements OnInit {

  type: any;
  name: any;
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
        console.log('onmessage: Received: ' + msg.data);
      }

      this.socket.onclose = function () {
        this.socket = null;
      }

    } catch (exception) {
      console.log('Error' + exception);
    }
  }
  newAgent() {
    console.log(this.type + " " + this.name);
    this.service.createNewAgent(this.type,this.name).subscribe(
      (data) => {
      }
    )

  }

}

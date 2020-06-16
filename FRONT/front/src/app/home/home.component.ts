import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { environment } from './../../environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  agents : any;
  agentTypes : any;
  host : any;
  socket : any;
  constructor(public service : ServiceService) { }

  ngOnInit() {
    this.getAgents();
    this.getClasses();
    
    this.host = "ws://" + environment.baseAddress + ":8080/WAR2020/ws";

    try {
      this.socket = new WebSocket(this.host);
      var self = this;

      this.socket.onopen = function () {

      }

      this.socket.onmessage = function (msg) {
        console.log('Dodat novi agent: ' + msg.data);
        this.getAgents();

      }

      this.socket.onclose = function () {
        this.socket = null;
      }

    } catch (exception) {
      console.log('Error' + exception);
    }
  }
  getAgents() {
    this.service.getRunningAgents().subscribe(
      (data) => {
        this.agents = data;
      }
    )
  }
  getClasses() {
    this.service.getAgentClasses().subscribe(
      (data) => {
        this.agentTypes = data;
      }
    )
  }

}

import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MazeBuilderComponent }  from './mazeBuilder.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  imports:      [ BrowserModule,
                  FormsModule],
  declarations: [ MazeBuilderComponent],
  bootstrap:    [ MazeBuilderComponent ]
})
export class AppModule { }

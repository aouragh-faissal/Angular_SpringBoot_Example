import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent {

  hero: any;
  id: any;

  constructor(private act: ActivatedRoute, private _shared : SharedService, private router: Router){}


  update(){
    this._shared.update(this.id , this.hero).subscribe(
      res=>{
        console.log(res);
        this.router.navigate(['/list']);
      },
      err=>{
        console.log(err);
      }
    );

  }

  ngOnInit(): void{
    this.id = this.act.snapshot.paramMap.get('id');

    this._shared.getById(this.id).subscribe(
      res=>{
        this.hero = res;
      },
      err=>{
        console.log(err);
      }
    );

  }

}

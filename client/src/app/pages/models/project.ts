export class ProjectVM{
    subCategory:String;
    category:String;
    country:String;
}


export class ResObj<T>{
    code:number;
    description:string;
    header:string;
    obj:Array<T>;
    status:string;
    _body:Array<T>;
}

export class KickStarter{
    ID:String;
    name:String;
    category:String;
    main_category:String;
    currency:String;
    deadline:String;
    goal:String;
    launched:String;
    pledged:String;
    state:String;
    backers:String;
    country:String;
    usd_pledged:String;
    usd_pledged_real:String;
    usd_goal_real:String;
}
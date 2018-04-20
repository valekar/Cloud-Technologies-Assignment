export class URLS{
    //prod
    //public static cloud_provider = "https://server-cloud-heroku.herokuapp.com";
    //public static cloud_provider = "http://cloud-env.vmfc4stcsn.eu-west-1.elasticbeanstalk.com/";
    //dev
    public static cloud_provider = "";
    
  

    public static GET_CATEGORIES = URLS.cloud_provider +"/api/categories/";
    public static GET_SUB_CATEGORIES = URLS.cloud_provider + "/api/sub/categories/";
    public static GET_COUNTRIES = URLS.cloud_provider + "/api/countries/";

    public static GET_TOP_PROJECTS = URLS.cloud_provider + "/api/projects/";
}
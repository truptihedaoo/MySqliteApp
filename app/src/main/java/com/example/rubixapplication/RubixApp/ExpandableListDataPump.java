package com.example.rubixapplication.RubixApp;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rubixapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump extends AppCompatActivity {


    public static HashMap<String, List<Child>> getData(MainActivity main2Activity) {
        HashMap<String, List<Child>> expandableListDetail = new HashMap<String, List<Child>>();

        RubixDBHelper mydb;


        mydb = new RubixDBHelper( main2Activity );
        String iphonex = "https://homepages.cae.wisc.edu/~ece533/images/airplane.png";
        String iphoneX = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2F5pO_06rSCHCiTilHMn-lKPR72hA%3D%2F0x0%3A2020x1338%2F1200x675%2Ffilters%3Afocal(849x508%3A1171x830)%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_image%2Fimage%2F65473625%2Ftwarren_iphone11propixel4_1.0.jpg&imgrefurl=https%3A%2F%2Fwww.theverge.com%2F2019%2F10%2F15%2F20915462%2Fgoogle-pixel-4-xl-iphone-11-pro-camera-comparison-test-photos-specs&tbnid=5qqouI_de_e7OM&vet=12ahUKEwiS2o_UwKrsAhUJSysKHX5lDeEQMygRegUIARDPAQ..i&docid=QV9NXg5mQNtDvM&w=1200&h=675&q=iphone%20X%20mobile%20image%20sample&ved=2ahUKEwiS2o_UwKrsAhUJSysKHX5lDeEQMygRegUIARDPAQ";
        String smasungX ="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.fonearena.com%2Fblog%2F246538%2Fsamsung-galaxy-s9-plus-camera-samples.html&psig=AOvVaw15BK-Dz4ilEIGLMdJn8Sjg&ust=1602435735366000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLDu17vAquwCFQAAAAAdAAAAABAD";
        String iphone6 = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fcdn.mos.cms.futurecdn.net%2FSHQVCeEhogabftHGm5waif-1200-80.jpg&imgrefurl=https%3A%2F%2Fwww.techradar.com%2Freviews%2Fiphone-se&tbnid=TobxfVtAq1hO4M&vet=12ahUKEwjpyOWRwKrsAhUChUsFHbqoBFQQMygSegUIARDbAQ..i&docid=EA6WHQF4601tJM&w=1200&h=675&q=iphone%206%20mobile%20image%20sample&ved=2ahUKEwjpyOWRwKrsAhUChUsFHbqoBFQQMygSegUIARDbAQ";
        String appleimage = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.hardwarezone.com.sg%2Ffeature-apple-iphone-11-and-iphone-11-pro-review%2Fcamera-systems-and-sample-images&psig=AOvVaw3vIYEGas0-PZq54f3cerQr&ust=1602434941765000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKjSj7-9quwCFQAAAAAdAAAAABAD";
        String samsungimage = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.gizguide.com%2F2019%2F06%2Fsamsung-galaxy-a20-first-camera-samples.html&psig=AOvVaw1_-S7lA75r3o2T-Z359cco&ust=1602435059497000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCPkPu9quwCFQAAAAAdAAAAABAD";

        mydb.insertMobile( "Apple", 1, "iphone 6", iphonex, "2020-22-05", "10.5", "2.5" );
        mydb.insertMobile( "Apple", 2, "iphone 6 s", iphone6, "2020-25-05", "24.5", "3.5" );
        mydb.insertMobile( "Apple", 3, "iphone 7", iphonex, "2020-30-05", "30.5", "5" );
        mydb.insertMobile( "Apple", 4, "iphone 8", appleimage, "2020-12-05", "40.5", "4" );
        mydb.insertMobile( "Apple", 5, "iphone X", iphonex, "2020-05-05", "50.5", "3.5" );
        mydb.insertMobile( "Apple", 6, "iphone XR", iphonex, "2020-23-05", "60.5", "1.5" );


        mydb.insertMobile( "Samsung", 1, "S7", samsungimage, "2020-22-05", "10.5", "2.5" );
        mydb.insertMobile( "Samsung", 2, "S8", iphonex, "2020-25-05", "24.5", "3.5" );
        mydb.insertMobile( "Samsung", 3, "S9", iphonex, "2020-30-05", "30.5", "5" );
        mydb.insertMobile( "Samsung", 4, "S10", samsungimage, "2020-12-05", "40.5", "4" );
        mydb.insertMobile( "Samsung", 5, "Note 7", samsungimage, "2020-05-05", "50.5", "3.5" );
        mydb.insertMobile( "Samsung", 6, "Note 8", iphonex, "2020-113-05", "60.5", "5" );
        mydb.insertMobile( "Samsung", 7, "Note 9", smasungX, "2020-15-05", "70.5", "3.5" );
        mydb.insertMobile( "Samsung", 8, "Note 10", iphonex, "2020-20-05", "80.5", "0" );
        mydb.insertMobile( "Samsung", 9, "Note 11", smasungX, "2020-10-05", "90.5", "2.5" );



        ArrayList<Child> iphoneArraylist = mydb.getAllMobiles( main2Activity.getResources().getString( R.string.apple ));
        ArrayList<Child> samsungArraylist = mydb.getAllMobiles( main2Activity.getResources().getString( R.string.samsung) );


        expandableListDetail.put(main2Activity.getResources().getString( R.string.apple ), iphoneArraylist );
        expandableListDetail.put(main2Activity.getResources().getString( R.string.samsung ), samsungArraylist );

        return expandableListDetail;
    }

    public static HashMap<String, List<Child>> getDataDate(MainActivity main2Activity) {
        HashMap<String, List<Child>> expandableListDetail = new HashMap<String, List<Child>>();

        RubixDBHelper mydb;


        mydb = new RubixDBHelper( main2Activity );


        ArrayList<Child> iphoneArraylist1 = mydb.getAllMobilesDate(  main2Activity.getResources().getString( R.string.apple ) );
        ArrayList<Child> samsungArraylist2 = mydb.getAllMobilesDate(  main2Activity.getResources().getString( R.string.samsung ) );

        expandableListDetail.put( main2Activity.getResources().getString( R.string.apple ), iphoneArraylist1 );
        expandableListDetail.put( main2Activity.getResources().getString( R.string.samsung ), samsungArraylist2 );


        return expandableListDetail;
    }

    public static HashMap<String, List<Child>> getDataRate(MainActivity main2Activity) {
        HashMap<String, List<Child>> expandableListDetail = new HashMap<String, List<Child>>();

        RubixDBHelper mydb;


        mydb = new RubixDBHelper( main2Activity );

        ArrayList<Child> iphoneArraylist = mydb.getAllMobilesRating( main2Activity.getResources().getString( R.string.apple ) );
        ArrayList<Child> samsungArraylist = mydb.getAllMobilesRating(main2Activity.getResources().getString( R.string.samsung ) );

        expandableListDetail.put(main2Activity.getResources().getString( R.string.apple ), iphoneArraylist );
        expandableListDetail.put(main2Activity.getResources().getString( R.string.samsung ), samsungArraylist );


        return expandableListDetail;
    }

    public static HashMap<String, List<Child>> getDataQuantity(MainActivity main2Activity) {
        HashMap<String, List<Child>> expandableListDetail = new HashMap<String, List<Child>>();

        RubixDBHelper mydb;


        mydb = new RubixDBHelper( main2Activity );


        ArrayList<Child> iphoneArraylist = mydb.getAllMobilesQuantity(main2Activity.getResources().getString( R.string.apple ) );
        ArrayList<Child> samsungArraylist = mydb.getAllMobilesQuantity(main2Activity.getResources().getString( R.string.samsung ) );

        expandableListDetail.put(main2Activity.getResources().getString( R.string.apple ), iphoneArraylist );
        expandableListDetail.put(main2Activity.getResources().getString( R.string.samsung ), samsungArraylist );


        return expandableListDetail;
    }
}
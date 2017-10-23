package com.senamoviles.alcayata.alcayatanew;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.droidbyme.dialoglib.DroidDialog;
import com.github.javiersantos.bottomdialogs.BottomDialog;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.senamoviles.alcayata.alcayatanew.Fragments.CitaFragment;
import com.senamoviles.alcayata.alcayatanew.Fragments.DescFragment;
import com.senamoviles.alcayata.alcayatanew.Fragments.DocFragment;
import com.senamoviles.alcayata.alcayatanew.Fragments.ModeloFragment;
import com.senamoviles.alcayata.alcayatanew.Fragments.SabiasFragment;
import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mrapp.android.dialog.WizardDialog;

public class MainActivity extends AppCompatActivity {

    public static String opcion = "San Juan Evangelista";
    public static final String TAG = "Semana Santa";
    public static String tagfragment = "";
    private String sabias = "";
    private String sabiasMas = "";
    private String descripcion = "";
    private String referencia = "";
    private String infoModelo = "";

    @BindView(R.id.frame_fragment_containers)
    FrameLayout frameFragmentContainers;
    @BindView(R.id.botton_nav)
    BottomNavigation bottonNav;

    Fragment fragment = null;
    Fragment frg = null;
    private FragmentTransaction transaction;
    Fragment currentFragment = null;
    BoomMenuButton bmb;
    FragmentManager fragmentManager;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        assert bmb != null;
        bmb.bringToFront();
        bmb.setButtonEnum(ButtonEnum.Ham);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_4);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_4);

        HamButton.Builder builder = new HamButton.Builder()

                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        opcion = "San Juan Evangelista";
                        linearLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.juan));
                        currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_fragment_containers);
                        recargaFrag(currentFragment);
                        Toast.makeText(MainActivity.this,"presionado: "+index,Toast.LENGTH_SHORT).show();

                    }
                })
                .normalImageRes(R.drawable.ic_juan)
                .normalText("San Juan Evangelista")
                .normalTextColor(Color.rgb(251,192,45))
                .normalColor(Color.rgb(53,5,23)) //119,72,23
                .highlightedColor(Color.rgb(251,192,45))
                .subNormalText("Imagen española del siglo XVIII");

        bmb.addBuilder(builder);

        HamButton.Builder builder1 = new HamButton.Builder()
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        opcion = "El señor del Huerto";
                        //recargar fragment Info
                        linearLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.huerto));
                        currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_fragment_containers);
                        recargaFrag(currentFragment);
                        Toast.makeText(MainActivity.this,"presionado: "+index,Toast.LENGTH_SHORT).show();
                    }
                })
                .normalImageRes(R.drawable.ic_huerto)
                .normalText("El Señor del Huerto")
                .normalTextColor(Color.rgb(251,192,45))
                .normalColor(Color.rgb(53,5,23))
                .highlightedColor(Color.rgb(251,192,45))
                .subNormalText("Talla quiteña del siglo XVII");
        bmb.addBuilder(builder1);

        HamButton.Builder builder2 = new HamButton.Builder()
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        opcion = "El Crucifijo";
                        linearLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.crucifijo));
                        currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_fragment_containers);
                        recargaFrag(currentFragment);
                        Toast.makeText(MainActivity.this,"presionado: "+index,Toast.LENGTH_SHORT).show();
                    }
                })
                .normalImageRes(R.drawable.ic_crucifijo)
                .normalText("El Crucifijo")
                .normalColor(Color.rgb(53,5,23))
                .normalTextColor(Color.rgb(251,192,45))
                .highlightedColor(Color.rgb(251,192,45))
                .subNormalText("Imagene española del siglo XVIII");
        bmb.addBuilder(builder2);

        HamButton.Builder builder3 = new HamButton.Builder()
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        opcion = "Virgen de los Dolores";
                        linearLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.virgen));
                        currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_fragment_containers);
                        recargaFrag(currentFragment);
                        //Toast.makeText(MainActivity.this,"presionado: "+index,Toast.LENGTH_SHORT).show();

                    }
                })
                .normalImageRes(R.drawable.ic_virgen)
                .normalText("Virgen de los Dolores")
                .normalColor(Color.rgb(53,5,23))
                .normalTextColor(Color.rgb(251,192,45))
                .highlightedColor(Color.rgb(251,192,45))
                .subNormalText("Imágen colombiana del siglo XX");
        bmb.addBuilder(builder3);

        //bottonNav.setDefaultItem(2);



        bottonNav.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int i) {
                setData();
                switch (i){
                    case R.id.item_3d:
                        /*transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new ModeloFragment());
                        fragment = new ModeloFragment();*/
                        boolean wrapInScrollView = true;
                        new MaterialDialog.Builder(MainActivity.this)
                                .customView(R.layout.sabias_con_audio,wrapInScrollView)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        break;
                    case R.id.item_desc:
                        new DroidDialog.Builder(MainActivity.this)
                                .icon(R.drawable.ic_huerto)
                                .title("Descripción")
                                .color(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorPrimary)
                                .content(descripcion)
                                .cancelable(true,true)
                                .positiveButton("Cerrar", new DroidDialog.onPositiveListener() {
                                    @Override
                                    public void onPositive(Dialog dialog) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        break;
                    case R.id.item_cita:
                        new DroidDialog.Builder(MainActivity.this)
                                .icon(R.drawable.ic_huerto)
                                .title("Cita Biblica")
                                .color(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorPrimary)
                                .content(referencia)
                                .cancelable(true,true)
                                .positiveButton("Cerrar", new DroidDialog.onPositiveListener() {
                                    @Override
                                    public void onPositive(Dialog dialog) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();

                        break;
                    case R.id.item_sabias:
                        /*transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new SabiasFragment());
                        fragment = new SabiasFragment();*/
                        new DroidDialog.Builder(MainActivity.this)
                                .icon(R.drawable.ic_huerto)
                                .title("Sabias Qué?")
                                .color(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorPrimary)
                                .content(sabias)

                                .cancelable(true,true)
                                .positiveButton("Leer más", new DroidDialog.onPositiveListener() {
                                    @Override
                                    public void onPositive(Dialog dialog) {
                                        dialog.dismiss();
                                        new BottomDialog.Builder(MainActivity.this)
                                                .setTitle("Awesome!")
                                                .setContent(sabiasMas)
                                                .show();
                                    }
                                })
                                .show();
                        break;
                    case R.id.item_download:
                        /*transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new DocFragment());
                        fragment = new DocFragment();*/
                        break;
                }
                //transaction.commit();
            }
        });

    }

    public void recargaFrag(Fragment f){
        if(f instanceof SabiasFragment){
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_fragment_containers,new SabiasFragment());
            fragment = new SabiasFragment();
            transaction.commit();
        }else if(f instanceof CitaFragment){
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_fragment_containers,new CitaFragment());
            fragment = new CitaFragment();
            transaction.commit();

        }else if(f instanceof DocFragment){
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_fragment_containers,new DocFragment());
            fragment = new DocFragment();
            transaction.commit();
        }else if(f instanceof ModeloFragment){
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_fragment_containers,new ModeloFragment());
            fragment = new ModeloFragment();
            transaction.commit();
        }else if(f instanceof DescFragment){
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_fragment_containers,new DescFragment());
            fragment = new DescFragment();
            transaction.commit();
        }

    }

    public void setData(){
        switch (opcion){
            case "San Juan Evangelista":
                descripcion = getResources().getString(R.string.descripcionJuan);
                sabias = getResources().getString(R.string.sabiasJuan);
                sabiasMas = getResources().getString(R.string.sabiasMasJuan);
                referencia = getResources().getString(R.string.refJuan);
                infoModelo = getResources().getString(R.string.info_modeloJuan);
                break;
            case "El señor del Huerto":
                descripcion = getResources().getString(R.string.descripcionhuerto);
                sabias = getResources().getString(R.string.sabiasHuerto);
                sabiasMas = getResources().getString(R.string.sabiasMasHuerto);
                referencia = getResources().getString(R.string.refHuerto);
                infoModelo = getResources().getString(R.string.info_modeloHuerto);
                break;
            case "Virgen de los Dolores":
                descripcion = getResources().getString(R.string.descripcionVirgen);
                sabias = getResources().getString(R.string.sabiasVirgen);
                sabiasMas = getResources().getString(R.string.sabiasMasVirgen);
                referencia = getResources().getString(R.string.refVirgen);
                infoModelo = getResources().getString(R.string.info_modeloVirgen);
                break;
            case "El Crucifijo":
                descripcion = getResources().getString(R.string.descripcionCrucifijo);
                sabias = getResources().getString(R.string.sabiasCrucifijo);
                sabiasMas = getResources().getString(R.string.sabiasMasCrucifijo);
                referencia = getResources().getString(R.string.refCrucifijo);
                infoModelo = getResources().getString(R.string.info_modeloCrucifijo);
                break;

        }
    }


}

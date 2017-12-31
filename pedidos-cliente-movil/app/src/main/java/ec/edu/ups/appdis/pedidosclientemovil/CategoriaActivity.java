package ec.edu.ups.appdis.pedidosclientemovil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ec.edu.ups.appdis.pedidosclientemovil.modelo.Categoria;
import ec.edu.ups.appdis.pedidosclientemovil.modelo.Respuesta;
import ec.edu.ups.appdis.pedidosclientemovil.utilidades.ClienteRest;
import ec.edu.ups.appdis.pedidosclientemovil.utilidades.OnTaskCompleted;
import ec.edu.ups.appdis.pedidosclientemovil.utilidades.Util;

public class CategoriaActivity extends AppCompatActivity implements View.OnClickListener, OnTaskCompleted {

    private static final int SOLICITUD_GUARDAR_CATEGORIA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        ((Button) findViewById(R.id.btnGuardarCategoria)).setOnClickListener(this);
    }

    @Override
    public void onTaskCompleted(int idSolicitud, String result) {
        switch (idSolicitud){
            case SOLICITUD_GUARDAR_CATEGORIA:
                if(result!=null){
                    try {
                        Respuesta res = ClienteRest.getResult(result, Respuesta.class);
                        Util.showMensaje(this, res.getMensaje());
                        if (res.getCodigo() == 1) {
                            finish();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        Util.showMensaje(this,R.string.msj_error_clienrest_formato);
                    }
                }else
                    Util.showMensaje(this,R.string.msj_error_clienrest);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGuardarCategoria:
                confirmarGuardarCategoria();
                break;
            default:
                break;
        }
    }

    /**
     * Procedimiento para validar y confirmar la transaccion,
     */
    private void confirmarGuardarCategoria() {
        String pregunta = "Esto seguro de realizar guardar la categoria?";
        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.msj_confirmacion))
                .setMessage(pregunta)
                .setNegativeButton(android.R.string.cancel, null)//sin listener
                .setPositiveButton(getResources().getString(R.string.lbl_aceptar),
                        new DialogInterface.OnClickListener() {//un listener que al pulsar, solicite el WS de Transsaccion
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                guardarCategoria();
                            }
                        })
                .show();
    }

    private void guardarCategoria(){
        int id;
        try {
            id = Integer.parseInt(((EditText) findViewById(R.id.txtCodigo)).getText().toString());
        }catch (Exception e){
            Util.showMensaje(this, "Formato incorrecto en código, revisar...");
            return;
        }
        String nombre = ((EditText) findViewById(R.id.txtNombre)).getText().toString();
        try {
            String URL = Util.URL_SRV + "pedidos/guardar";
            ClienteRest clienteRest = new ClienteRest(this);
            Categoria categoria = new Categoria();
            categoria.setCategoriaid(id);
            categoria.setNombrecat(nombre);
            clienteRest.doPost(URL, categoria, SOLICITUD_GUARDAR_CATEGORIA, true);
        }catch(Exception e){
            Util.showMensaje(this, R.string.msj_error_clienrest);
            e.printStackTrace();
        }
    }
}

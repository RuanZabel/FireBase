package com.example.meuappfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //criando uma instancia do banco
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        //Salvar um dado
        //reference.child("usuarios").child("id").child("03").child("nome").setValue("Manu");
//        Usuario usuario= new Usuario("001","Lena",29,"lena.hotmail.com");
//        reference.child("usuarios").push().setValue(usuario);
//        usuario = new Usuario("001","Manu",4,"manu.hotmail.com");
//        reference.child("usuarios").push().setValue(usuario);
//        usuario = new Usuario("001","Ruan",28,"Ruan.hotmail.com");
//        reference.child("usuarios").push().setValue(usuario);
//        usuario = new Usuario("001","Wagner",26,"wag.hotmail.com");
//        reference.child("usuarios").push().setValue(usuario);
//        usuario = new Usuario("001","Eu",28,"Eu.hotmail.com");
//        reference.child("usuarios").push().setValue(usuario);

        // recuperando dados
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Log.i("Firebase",dataSnapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //recuperando dados a partir de um id
//        DatabaseReference referenceUsuario = reference.child("usuarios").child("-LgnWfaE725X5hQAd-20");
//        referenceUsuario.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Usuario user = dataSnapshot.getValue(Usuario.class);
//                Log.i("Firebase","Nome: "+user.getNome());
//                Log.i("Firebase","id: "+user.getcadigo());
//
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        //recuperando com query
//        DatabaseReference referenceUsuario = reference.child("usuarios");
//        Query usuarioPesuisa = referenceUsuario.orderByChild("nome").equalTo("Ruan");
//
//        usuarioPesuisa.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //pegar os dados
//                Usuario user = dataSnapshot.getChildren().iterator().next().getValue(Usuario.class);
//                Log.i("Firebase","Nome: "+user.getNome());
//                Log.i("Firebase","id: "+user.getcadigo());
//
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //query com maior e menor

//        DatabaseReference referenceUsuario = reference.child("usuarios");
//        Query usuarioPesuisa = referenceUsuario.orderByChild("nome").startAt("M").endAt("R");
//
//        usuarioPesuisa.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //pegar os dados
//                Log.i("Firebase",dataSnapshot.getValue().toString());
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //autenticação de usuario
        firebaseAuth.createUserWithEmailAndPassword("ruancrepesmaximo@hotmail.com","12345ruan")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //podemos verificar se deu certo o cadastro de usuario
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "usuario criado", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "usuario já existe", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}

package pt.ipp.estg.projeto_kidszone.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import pt.ipp.estg.projeto_kidszone.R;

public class JogoCompCategorias extends Fragment  {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogo_comp_categorias, container, false);

        Button btnIngl= (Button) view.findViewById(R.id.btnIngl);
        Button btnPt= (Button) view.findViewById(R.id.btnPt);
        Button btnMat= (Button) view.findViewById(R.id.btnMat);

        btnIngl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   mListener.fragmentsComunication("Inglês");

            }
        });

        btnPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.fragmentsComunication("Português");
            }
        });

        btnMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.fragmentsComunication("Matemática");
            }
        });

        return view;
    }
    public interface fragmentsComunication {
        void fragmentsComunication(String nome_catg);
    }

    private fragmentsComunication mListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (fragmentsComunication) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " deve implementar fragmentsComunication");
        }
    }


}

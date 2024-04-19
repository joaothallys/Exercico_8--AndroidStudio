package com.example.atividade81;


import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.navigation.Navigation;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        Button btnGoToFragment2 = view.findViewById(R.id.btnGoToFragment2);
        btnGoToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicialize o MediaPlayer com o som desejado
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.cigarrinho);

                // Verifique se o MediaPlayer foi inicializado corretamente
                if (mediaPlayer != null) {
                    // Reproduza o som
                    mediaPlayer.start();
                    // Libere o MediaPlayer após a reprodução para liberar recursos
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                }

                // Navegue para o BlankFragment2
                Navigation.findNavController(v).navigate(R.id.action_blankFragment_to_blankFragment2);
            }
        });

        return view;
    }
}

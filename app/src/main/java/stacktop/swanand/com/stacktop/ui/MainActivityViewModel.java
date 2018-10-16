package stacktop.swanand.com.stacktop.ui;

import java.util.ArrayList;
import java.util.List;


import androidx.lifecycle.ViewModel;
import stacktop.swanand.com.stacktop.data.Repository;
import stacktop.swanand.com.stacktop.datamodel.Item;

public class MainActivityViewModel extends ViewModel {



    List<Item> questions ;
    private final Repository mRepository;

    public MainActivityViewModel( Repository repository) {

        mRepository = repository;

        questions = mRepository.getQuestions();


    }

    public List<Item> getQuestions() {

        return mRepository.getQuestions();
    }
}

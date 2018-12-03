package stacktop.swanand.com.stacktop.ui;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import stacktop.swanand.com.stacktop.data.Repository;
import stacktop.swanand.com.stacktop.datamodel.Item;

public class MainActivityViewModel extends ViewModel {


    LiveData<List<Item>> questions;
    private final Repository mRepository;

    public MainActivityViewModel(Repository repository) {

        mRepository = repository;

        questions = mRepository.getQuestions();


    }

    public LiveData<List<Item>> getQuestions() {

        return questions;
    }
}

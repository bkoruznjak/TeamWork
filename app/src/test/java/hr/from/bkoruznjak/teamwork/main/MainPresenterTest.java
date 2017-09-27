package hr.from.bkoruznjak.teamwork.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import hr.from.bkoruznjak.teamwork.main.model.Result;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by bkoruznjak on 27/09/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainView view;
    @Mock
    MainInteractor mainInteractor;

    private MainPresenterImpl mMainPresenter;

    @Before
    public void setUp() throws Exception {
        mMainPresenter = new MainPresenterImpl(view);
    }

    @Test
    public void doesShowProgressOnResume() {
        mMainPresenter.onResume();
        verify(view, atLeastOnce()).showProgress();
    }

    @Test
    public void isViewReleasedOnDestroy() {
        mMainPresenter.onDestroy();
        assertNull(mMainPresenter.getMainView());
    }

    @Test
    public void areItemsPassedToView() {
        List<Result> results = new ArrayList<>(5);
        results.add(new Result("abc"));
        results.add(new Result("afc"));
        results.add(new Result("ara"));
        results.add(new Result("afg"));
        results.add(new Result("adr"));

        mMainPresenter.onSuccess(results);
        verify(view, times(1)).setItems(results);
        verify(view, times(1)).hideProgress();
    }

    @Test
    public void isItemBeingClicked() {
        mMainPresenter.onItemClicked(1);
        verify(view, times(1)).showMessage(anyString());
    }
}

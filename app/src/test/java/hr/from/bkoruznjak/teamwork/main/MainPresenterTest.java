package hr.from.bkoruznjak.teamwork.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import hr.from.bkoruznjak.teamwork.main.contract.MainInteractor;
import hr.from.bkoruznjak.teamwork.main.contract.MainView;
import hr.from.bkoruznjak.teamwork.network.TeamWebApi;
import hr.from.bkoruznjak.teamwork.network.model.AllProjectsResponseModel;
import hr.from.bkoruznjak.teamwork.network.model.Project;
import hr.from.bkoruznjak.teamwork.root.AppComponent;

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
    AppComponent appComponent;
    @Mock
    MainInteractor mainInteractor;

    private MainPresenterImpl mMainPresenter;

    @Before
    public void setUp() throws Exception {
        mMainPresenter = new MainPresenterImpl(view, appComponent);
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
        AllProjectsResponseModel response = new AllProjectsResponseModel();
        response.setSTATUS("OK");
        response.setProjects(new ArrayList<Project>(5));

        mMainPresenter.onSuccess(response);
        verify(view, times(1)).setItems(response.getProjects());
        verify(view, times(1)).hideProgress();
    }

    @Test
    public void isItemBeingClicked() {
        mMainPresenter.onItemClicked(1);
        verify(view, times(1)).showMessage(anyString());
    }

    @Test
    public void areProjectsBeingReturnedForUser() {
        mMainPresenter.loadUserProjectsToUi(TeamWebApi.USERNAME);

    }

}

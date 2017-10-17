package com.lnavarro.heroescleanarchitectureconcept.modules.common.presentation.presenter;

public interface BasePresenter {
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onCreateView() method.
     */
    void create();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onStop() method.
     */
    void stop();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();


    /**
     * Method that should signal the appropriate view to show the appropriate error with the provided message.
     */
    void onError(String message);


    /**
     * Method that should refresh data requesting repository
     */
    void refresh();


}

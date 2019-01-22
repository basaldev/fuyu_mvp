(ns fuyu_mvp.components.app
  (:require [fuyu_mvp.domain.store :as store]
            [fuyu_mvp.domain.middlewares.user :as user]
            [fuyu_mvp.components.message :as message]
            [fuyu_mvp.components.drill-hiragana-1 :as drill-1]))

(defn get-classes []
  (if (store/get-answered?)
    (if (store/get-correct?) "win" "lose") ""))

(defn main []
  (let [question (store/get-question)
        missing (store/get-missing)
        options (store/get-options)
        selection (store/get-selection)
        selecting? (store/get-selecting?)
        hovering? (store/get-hovering?)
        answered? (store/get-answered?)
        correct? (store/get-correct?)]
    [:div { :id "app" :class (get-classes) }
      [:div { :class "viewport" }
        [message/main
          selecting?
          hovering?
          answered?
          correct?]
        [drill-1/main
          question
          missing
          options
          selection
          selecting?
          hovering?
          answered?
          correct?
          user/select-word
          user/unselect-word
          user/decide-word
          user/enter-form
          user/leave-form]
        [:button
          {:on-click (fn [] (user/play-again))}
          "Play Again"]]]))
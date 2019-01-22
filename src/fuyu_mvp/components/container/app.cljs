(ns fuyu_mvp.components.app
  (:require [fuyu_mvp.domain.store :as store]
            [fuyu_mvp.domain.middlewares.user :as user]
            [fuyu_mvp.components.pool :as pool]
            [fuyu_mvp.components.message :as message]
            [fuyu_mvp.components.form :as form]))

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
        [form/main
          question
          missing
          options
          selection
          selecting?
          hovering?
          answered?
          correct?
          user/decide-word
          user/enter-form
          user/leave-form]
        [pool/main
          options
          selection
          selecting?
          correct?
          user/select-word
          user/unselect-word]]]))

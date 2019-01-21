(ns fuyu_mvp.components.app
  (:require [fuyu_mvp.domain.store :as store]
            [fuyu_mvp.domain.middlewares.user :as user]
            [fuyu_mvp.components.drill-hiragana-1 :as drill-1]))

(defn main []
  (let [state @store/state]
    [drill-1/main
      (store/get-question)
      (store/get-missing)
      (store/get-options)
      (store/get-selection)
      (store/get-selecting?)
      (store/get-hovering?)
      (store/get-answered?)
      (store/get-correct?)
      user/select-word
      user/unselect-word
      user/decide-word
      user/enter-form
      user/leave-form]))

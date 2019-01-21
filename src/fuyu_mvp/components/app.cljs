(ns fuyu_mvp.components.app
  (:require [fuyu_mvp.domain.store :as store]
            [fuyu_mvp.domain.middlewares.user :as user]
            [fuyu_mvp.components.drill-hiragana-1 :as drill-1]))

(defn main []
  (let [state @store/state]
    [drill-1/main
      (state :question)
      (state :missing)
      (state :options)
      (state :selection)
      (state :selecting?)
      (state :correct?)
      user/select-word
      user/cancel-word
      user/decide-word]))

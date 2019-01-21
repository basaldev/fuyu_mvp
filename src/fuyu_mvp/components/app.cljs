(ns fuyu_mvp.components.app
  (:require [fuyu_mvp.domain.middlewares.user :as user]
            [fuyu_mvp.domain.store :as store]
            [fuyu_mvp.components.drill-hiragana-1 :as drill-1]))

(defn main []
  [drill-1/main
    (@store/state :question)
    (@store/state :missing)
    (@store/state :options)
    (@store/state :selecting?)
    (@store/state :correct?)
    user/select-word
    user/cancel-word
    user/decide-word])

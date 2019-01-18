(ns fuyu_mvp.components.app
  (:require [fuyu_mvp.components.drill-hiragana-1 :as drill-1]
            [fuyu_mvp.domain.store :as store]))

(defn main [] 
  [drill-1/main(@store/state :question) (@store/state :missing)])

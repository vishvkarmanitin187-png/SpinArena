import React, { useState } from 'react';
import { Tag, CheckCircle2, AlertCircle } from 'lucide-react';

interface Props {
  setBalance: React.Dispatch<React.SetStateAction<number>>;
}

export default function RedeemSection({ setBalance }: Props) {
  const [promoCode, setPromoCode] = useState('');
  const [message, setMessage] = useState<{ text: string; type: 'success' | 'error' } | null>(null);

  const handleRedeem = () => {
    if (!promoCode.trim()) {
      setMessage({ text: 'Kripya valid promo code enter karein!', type: 'error' });
      return;
    }

    // Example logic for redeem codes
    if (promoCode.toUpperCase() === 'WELCOME50' || promoCode.toUpperCase() === 'SPIN90') {
      const reward = 50;
      setBalance(prev => prev + reward);
      setMessage({ text: `Badhai ho! ₹${reward} aapke wallet mein add kar diye gaye hain.`, type: 'success' });
      setPromoCode('');
    } else {
      setMessage({ text: 'Galat ya expired promo code hai!', type: 'error' });
    }
  };

  return (
    <div className="bg-slate-900 border border-slate-800 rounded-2xl p-4 shadow-lg space-y-3">
      <div className="flex items-center space-x-2 text-amber-400">
        <Tag className="w-5 h-5" />
        <h4 className="text-sm font-bold text-white">Promo Code Redeem Karein</h4>
      </div>

      <p className="text-xs text-slate-400">
         Apna coupon ya gift code yahan enter karein aur instant bonus cash payen.
      </p>

      {message && (
        <div className={`p-2.5 rounded-xl text-xs flex items-center gap-2 ${
          message.type === 'success' 
            ? 'bg-emerald-500/20 border border-emerald-500/40 text-emerald-300' 
            : 'bg-red-500/20 border border-red-500/40 text-red-300'
        }`}>
          {message.type === 'success' ? <CheckCircle2 className="w-4 h-4" /> : <AlertCircle className="w-4 h-4" />}
          <span>{message.text}</span>
        </div>
      )}

      <div className="flex gap-2">
        <input 
          type="text"
          value={promoCode}
          onChange={(e) => setPromoCode(e.target.value)}
          placeholder="Jaise: WELCOME50"
          className="flex-1 bg-slate-950 border border-slate-800 rounded-xl px-3 py-2 text-sm text-white placeholder-slate-500 focus:outline-none focus:border-indigo-500 uppercase"
        />
        <button 
          onClick={handleRedeem}
          className="bg-gradient-to-r from-emerald-500 to-teal-600 hover:opacity-95 text-white font-bold text-xs px-4 py-2 rounded-xl shadow-md active:scale-95 transition-transform"
        >
          Redeem
        </button>
      </div>
    </div>
  );
}
￼Enter
